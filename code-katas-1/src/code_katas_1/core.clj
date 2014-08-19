(ns code-katas-1.core)

(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
  [s]
  (for [variableIterativa s :when (= (rem variableIterativa 2) 1)] variableIterativa)
  )

(defn nil-key                                  
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  (if (= (contains? m k) true) (true? (= (get m k) nil)) false)
  )

(defn rango
 "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
 [rengarStart rengarEnd]
 (println rengarStart)
 (conj rengarStart)
 (if (< rengarStart (- rengarEnd 1)) (rango (+ rengarStart 1) rengarEnd) "End"))


(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  )

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args])

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  [(take s) (drop s)]
  )

(defn inter-two                                  
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (defn fruta [lista devolver] (if (empty? lista) devolver (fruta (rest lista) (conj devolver (first lista)))))
  (fruta
  (for [variableQueItera (range(if(< (count s1) (count s2)) (count s1) (count s2)))] (concat [(nth s1 variableQueItera)] [(nth s2 variableQueItera)])
    ) [])

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  )

(defn find-truth                                 
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  (if (and (some true? xs) (some false? xs)) true false)
)

(defn zip-map                                    
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  (defn frutaDicc [dicc devolver] (if (empty? dicc) devolver (frutaDicc (rest dicc) (conj devolver (first dicc)))))
(clojure.set/map-invert (frutaDicc (for [i (range(if(< (count k) (count v)) (count k) (count v)))] {(nth v i) (nth k i)})  
   {})))

