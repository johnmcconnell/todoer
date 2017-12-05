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

(re-frame/reg-event-db
  ::edit-todo
  (fn [db [_ i]]
    (update-todos
      db
      #(update % i assoc :edit? true))))

(re-frame/reg-event-db
  ::cancel-edit-todo
  (fn [db [_ i]]
    (update-todos
      db
      #(update % i assoc :edit? false))))

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
        #(update % i assoc :text new-text :edit? false)))))
