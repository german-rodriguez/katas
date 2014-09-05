(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  
  (fn HashtagFuncion [& args] (reduce #(%1 %2) f args))
  )


(defn search 
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]

  (if 
    (or (= (first (sort (map first seqs)))
           (last (sort (map first seqs)))))
    
    (first (sort (map first seqs)))
    (recur
      (for [i seqs]
        (if (= (reduce min (map first seqs)) (first i))
          (rest i)
          i))))
)


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  (lazy-seq
  (if (and (first secuencia) (second secuencia))
    (if (predicado (first secuencia) (second secuencia))
      (concat [(first secuencia)] [valor] (intercalar predicado valor (rest secuencia)))
      (concat [(first secuencia)] (intercalar predicado valor (rest secuencia))))
    (when (not (= (first secuencia) nil)) (concat [(first secuencia)]))  
  )
    ))


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
 
  (fn fruta [numero sec cont lista]
    (if (and (= nil numero) (empty? sec)) 
      lista 
      (if (= numero (first sec)) 
        (fruta numero (rest sec) (+ cont 1) lista) 
        (fruta (first sec) (rest sec) 1 (conj lista cont numero))
        )
      )
    )
  (lazy-seq (cons (fruta (first secuencia) (rest secuencia) 1 []) (tartamudeo (fruta (first secuencia) (rest secuencia) 1 []))))
  )