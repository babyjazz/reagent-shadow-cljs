(ns starter.about
  (:require [reagent.core :as r]
            ["react-router-dom" :refer (Link)]
            [starter.global-state :as state]))

(defn About []
  [:div
   [:h1 "About page"]
   [:> Link {:to "/"}
    [:button "Go back"]]
   [:p (str "Global state number " @state/number)]])