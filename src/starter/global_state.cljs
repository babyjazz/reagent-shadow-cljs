(ns starter.global-state
  (:require [reagent.core :as r :refer [atom]]))

(def number (atom 1))
(defonce dev-number (atom 1)) ; state will not be reset when file is saved except reload page