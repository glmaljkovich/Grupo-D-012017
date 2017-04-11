# Comprando aLoLoco ..

Se busca la construcción de una aplicación de gestión de compras para usuarios de supermercados.

La aplicación debe permitir listar los productos para la venta para lo cual se debe poder cargar nombre, marca, stock, precio y una imagen. Estos productos pueden ser modificados por el **_ENCARGADO_** del local o puede actualizarse de manera batch por medio de un CSV donde se carga <id, Nombre, Marca, Stock, Precio, Imagen> . Imagen como una URL a una imagen pública.

Los compradores podrán crearse usuarios y crear listas de compras. Las listas incluyen nombre del producto y cantidad a comprar.

El **_COMPRADOR_** podrá ir tildando productos de su lista y el sistema irá llevando el monto gastado. El sistema también permitirá configurar alertas para notificarle al comprador si ha superado cierto umbral de diferencia histórica entre categorías de productos. **_Esta alerta se puede habilitar y deshabilitar_**.  
**_Ejemplo_**: 
  * Superó en 10% la categoría de bebidas alcohólicas.
  + Superó en 10% golosinas.

Una vez que el **_COMPRADOR_** terminó de comprar, podrá solicitar un turno en la línea de cajas. 

El sistema coordinará las cajas habilitadas y mantendrá la cola de espera de manera eficiente. Se deberá poder administrar la cantidad de cajas habilitadas y el tiempo promedio de atención teniendo en cuenta el tipo de producto o categoría.

Si el **_COMPRADOR_** decide que el tiempo de espera es demasiado, podrá seleccionar que lo envien a domicilio. Para ello, será necesario crear una dirección de envío, mostrarlo en un mapa de google maps y mostrar la distancia a su casa. Si el comprador decide está opción, se deberá notificar al sistema y trasladarse al sector de envíos para su procesamiento. El pago se hará en su casa cuando llegue el envío.

A partir de que un usuario se registre, podrá comenzar a definir su perfil. El perfil de usuario contendrá sus preferencias  de compras de categorías (umbrales) y monto de compra (umbral). Estas preferencias podrían cambiar o ampliarse más adelante.

La aplicación deberá ser completamente responsive ya que si bien ahora no vamos a contar con una aplicación mobile, será importante que pueda mostrarse correctamente en celulares y tablets. 

Es requisito indispensable proveer la capacidad de acceder a la aplicación utilizando una cuenta existente en alguna de las herramientas o redes sociales más utilizadas (gmail, facebook, twitter, etc). No obstante, se debe proveer una opción de crear usuario donde se deba ingresar NombreDeUsuario, email y contraseña.  

El **_ENCARGADO_** podrá crear ofertas por: 
  * Categorías de productos. 
  + Por producto.
  - Por combinación de 2 productos. 

La oferta será un porcentaje de descuento sobre el/los productos  donde aplicó la oferta. Estas ofertas tendrán una vigencia definida entre 2 fechas. El tipo de ofertas podrá cambiar dependiendo de la creatividad del área de marketing.

Los compradores podrán ver su historial de compras desde su perfil de usuario. Además el sistema también ofrecer los productos que quizás también le interese a medida que el usuario vaya comprando o “tildando” productos de su lista.
