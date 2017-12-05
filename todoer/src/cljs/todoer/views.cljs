(ns todoer.views
  (:require
    [re-frame.core :as re-frame]
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
     (for [todo @todos]
       [:button.list-group-item.list-group-item-action
        {:type :button}
        todo])]))

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
