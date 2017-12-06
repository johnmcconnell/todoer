(ns todoer.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body
   {:padding-top :5rem}]
  [:.cursor-pointer
   {:cursor :pointer}])
