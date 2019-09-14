(ns starter.home
  (:require [reagent.core :as r]
            [starter.global-state :as state]
            ["react" :as React]
            ["react-router-dom" :refer (Link)]))

(def fragment (r/adapt-react-class (.-Fragment React)))

(defn Home []
  [fragment
   [:div {:className "home"}
    [:img {:src "assets/img/image.png"
           :width 140
           :height 140}]
    [:h1 "Welcome to react with reagent"]
    [:h3 "Edit file at core.cljs"]
    [:> Link {:to "/about"}
     [:button "Go to about page"]]
    [:br]
    [:div {:style {:border "1px solid black"
                   :padding 20
                   :border-radius 10
                   :text-align "center"}}
      [:p (str "Global state number: " @state/number)]
      [:button {:on-click #(swap! state/number inc)} "inc number"]
      [:p "check state at about page"]]]])