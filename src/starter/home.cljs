(ns starter.home
  (:require
   [re-frame.core :as rf]
   [starter.utils.fetch :refer [fetch]]))


(defn Home []
  (def create-user-status (get-in @(rf/subscribe [:api]) [:create-user :status]))

  [:div {:className "home"}
   [:img {:src "assets/img/image.png"
          :width 140
          :height 140}]
   [:h1 "Welcome to react with reagent"]
   [:h3 "Edit file at core.cljs"]
   [:p "Toggle devtool by 'ctrl + h'"]
   [:button {:on-click #(fetch "https://reqres.in/api/users"
                               {:method "post"
                                :body {:name "morpheus"
                                       :job "leader"}
                                :dispatch :create-user})} "Fetch"]
   [:h1 "List of users"]
   (cond
     (not create-user-status) nil
     (:request? create-user-status) [:p "Creating"]
     :else (if (:success? create-user-status)
             [:p "Success"]
             [:p "Failed"]))])
