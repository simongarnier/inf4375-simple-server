(ns inf4375.model.tweet
  (:gen-class)
  (:require [inf4375.model-util :as util]))

(def tweets
  (atom {}))

(defn create! [message]
  (let [id (util/gen-id)]
    (swap! tweets conj {id {:id id
                            :message message
                            :timestamp (util/stamp)}})
    id))

(defn all []
  (vals @tweets))

(defn fetch [id]
  (get @tweets id))

(defn del! [id]
  (swap! tweets dissoc id))
