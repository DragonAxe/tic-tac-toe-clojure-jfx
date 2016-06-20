(ns clojure-fx.core
  (:require [fx-clj.core :as fx])
  (:import (javafx.scene.canvas Canvas)
           (javafx.scene.paint Color)
           (javafx.scene.input MouseEvent)
           (javafx.event EventHandler)))

;(def canv (fx/pset! (Canvas.) {:width 100 :height 100}))

;(.setFillColor (.getGraphicsContext2D canv) Color/GREEN)

(defn create-view []
  (let [borders (fx/border-pane)]
    (.setCenter borders
      (let [canv (fx/pset! (Canvas.) {:width 300 :height 300})]
        (.addEventHandler canv MouseEvent/MOUSE_CLICKED (new EventHandler))
        (let [g (.getGraphicsContext2D canv)]
          (.setFill g Color/GREEN)
          (.strokeLine g 0 100 300 100)
          (.strokeLine g 0 200 300 200)
          (.strokeLine g 100 0 100 300)
          (.strokeLine g 200 0 200 300))
        canv))
    borders))

(fx/sandbox #'create-view)

