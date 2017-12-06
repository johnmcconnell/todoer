(ns todoer.events
  (:require [re-frame.core :as re-frame]
            [todoer.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(defn update-todos
  [db f]
  (update
    db
    :todos
    (fn
      [todos]
      (-> todos vec f))))

(defn vec-dissoc
  [v i]
  (->>
    (subvec v (inc i))
    (concat (subvec v 0 i))
    vec))

(re-frame/reg-event-db
  ::edit-todo
  (fn [db [_ i]]
    (update-todos
      db
      #(update % i assoc :edit? true))))

(re-frame/reg-event-db
  ::save-todo
  (fn [db [_ i]]
    (let [jq (js* "$")
          new-text (->
                     (str "input.todo-" i)
                     jq
                     .val)]
      (update-todos
        db
        #(update % i assoc :text new-text :edit? false :new? false)))))

(re-frame/reg-event-db
  ::cancel-todo
  (fn [db [_ i]]
    (update-todos
      db
      (fn
        [todos]
        (let [{:keys [new?] :as todo} (get todos i)]
          (if new?
            (vec-dissoc todos i)
            (assoc todos i (assoc todo :edit? false))))))))

(re-frame/reg-event-db
  ::new-todo
  (fn [db _]
    (update-todos
      db
      #(conj % {:text "" :edit? true :new? true}))))

(re-frame/reg-event-db
  ::finish-todo
  (fn [db [_ i]]
    (let [{:keys [text]} (get-in db [:todos i])]
      (js/PNotify.
        (js-obj "title" "Finished!"
                "text" text
                "type" "success"
                "styling" "bootstrap3"
                "delay" 2000)))
    (update-todos
      db
      #(vec-dissoc % i))))
