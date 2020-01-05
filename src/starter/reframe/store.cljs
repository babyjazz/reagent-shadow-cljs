(ns starter.reframe.store
  (:require
   [re-frame.core :as rf]))
;    [reagent-serverside.router.router :refer [initial-page]]))

; Initial global state with re-frame; Like using redux
; -------------------------------
(rf/reg-event-db
 :initialize
 (fn []
   {:api {}}))

; subscribe key inside :initialize
; -------------------------------
(rf/reg-sub :initialized? (fn  [db] (not (empty? db))))
(rf/reg-sub :api (fn [db] (:api db)))
(rf/reg-sub :router (fn [db] (:router db)))