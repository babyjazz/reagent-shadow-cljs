(ns starter.reframe-example
  (:require [reagent.core :as r]
            [re-frame.core :as rf]))

(rf/reg-event-db ; Dispatch state, Like reducer
 :reset-number
 (fn [db [_ new-number]]
   (assoc db :number new-number)))

(rf/reg-event-db
 :inc-number
 (fn [db _]
   (assoc db :number (inc (get db :number)))))

(rf/reg-sub ; Subscribe state, Like connect()()
 :number
 (fn [db _]
   (:number db)))

(defn dispatch-number-event ; Like mapStateToProps
  [new-number]
  (rf/dispatch [:reset-number new-number]))

(defn ReframeExample []
  [:div
   [:p (str "Global state number: " @(rf/subscribe [:number]))]
   [:button {:on-click #(rf/dispatch [:inc-number])} "Inc number"]
   [:button {:on-click #(dispatch-number-event 0)} "Reset number to 0"]])