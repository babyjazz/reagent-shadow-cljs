(ns starter.about
  (:require [reagent.core :as r]
            ["react-router-dom" :refer (Link)]))

(defn About []
  [:div
   [:h1 "About page"]
   [:> Link {:to "/"}
    [:button "Go back"]]])