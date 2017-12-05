(ns todoer.views
  (:require
    [re-frame.core :as re-frame]
    [todoer.events :as ets]
    [todoer.subs :as sbs]))

(defn navbar-panel
  []
  (let [n (re-frame/subscribe [::sbs/name])]
    [:nav.navbar.navbar-expand-md.navbar-dark.bg-dark.fixed-top
     {:key "navigation-bar"}
     [:button.navbar-toggler.navbar-toggler-right
      {:type "button"
       :data-toggle "collapse"
       :data-target "#navbarsExampleDefault"
       :aria-controls "navbarsExampleDefault"
       :aria-expanded "false"
       :aria-label "Toggle navigation"}
      [:span {:class "navbar-toggler-icon"}]]
     [:a {:class "navbar-brand", :href "/"} @n]]))

(defn heading-panel
  []
  (let [n (re-frame/subscribe [::sbs/name])]
    [:div
     [:h1 @n]
     [:p.lead "Welcome! Please send bitcoin..."]]))

(defn todos
  []
  (let [todos (re-frame/subscribe [::sbs/todos])]
    [:div.list-group
     (for [[i {:keys [text edit?] :as todo}] @todos]
       (if edit?
         [:div.list-group-item.list-group-item-action
          {:key i}
          [:div.row
           [:div.col-auto.col-md-8
            [:input.form-control
             {:class (str "todo-" i)
              :default-value text}]]
           [:div.col-auto
            [:button.btn.btn-secondary
             {:type :button
              :on-click #(re-frame/dispatch [::ets/cancel-edit-todo i])}
             "Cancel"]]
           [:div.col-auto
            [:button.btn.btn-primary
             {:type :button
              :on-click #(re-frame/dispatch [::ets/save-todo i])}
             "Done"]]]]
         [:div.list-group-item.list-group-item-action
          {:key i
           :on-click #(re-frame/dispatch [::ets/edit-todo i])}
          text]))]))

(defn main-panel []
  (let [n (re-frame/subscribe [::sbs/name])]
    [:div
     [navbar-panel]
     [:main.container {:role "main"}
      [:div.starter-template
       [heading-panel]]
      [:div.row
       [:div.col-12
        [todos]]]]]))
