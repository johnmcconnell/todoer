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
    [:main.container {:role "main"}
     [:div.starter-template
      [:h1 @n]
      [:p.lead "Welcome! Please send bitcoin..."]]]))

(defn main-panel []
  (let [n (re-frame/subscribe [::sbs/name])]
    [:div
      [navbar-panel]
      [heading-panel]]))
