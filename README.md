# zk spring


```bash
se creo un archivo para la vista ubicado:
https://github.com/kevinm9/frontzksprin/blob/main/src/main/resources/web/zul/aplicacion.zul
se creo un arhivo que maneje la vista:  
frontzksprin/src/main/java/org/zkoss/zkspringboot/controller/controladordeapp.java
-se usuaron buenas prácticas dejando el manejo de la vista en el back sin ensuciar la vista con codigo.
-lleno de data tabla y un combobox de api externa.
-se llamo una api externa para mostrar informacion y validacion de identidad y posterior se habilta demas opciones
-se hace peticion post eviando datos del formulario llenado y posterior se traen los datos a la vista

para clonar este repo

https://github.com/kevinm9/frontzksprin.git

cd frontzksprin


ejecutar la app situandose en el repo y ejecutar 

mvn spring-boot:run

esta app se ejecuta en el puerto 8081 configurado en el archivos de propiedades 

application.properties

ruta :

http://localhost:8081/


recordar primero desplegar el backend

https://github.com/kevinm9/backclinicaspring

```
![alt text](https://raw.githubusercontent.com/kevinm9/frontzksprin/main/foto.png)
