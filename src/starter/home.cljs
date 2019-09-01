(ns starter.home
  (:require [reagent.core :as r]
            ["react" :as React]))

(def fragment (r/adapt-react-class (.-Fragment React)))

(defn Home []
  [fragment
   [:div {:className "home"}
    [:img {:src "assets/img/image.png"
           :width 140
           :height 140}]
    [:h1 "Welcome to react with reagent"]
    [:h3 "Edit file at core.cljs"]]])