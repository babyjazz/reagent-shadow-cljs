(ns starter.store
  (:require [re-frame.core :as rf]))

; Initial global state with re-frame; Like using redux
(rf/reg-event-db
 :initialize
 (fn [_ _]
   {:number 1}))