# Aplicación de Android.

--- 
## Contenido:

- <details>
  <summary>Java</summary>

    - <details>
        <summary>aplicacion</summary>

        - rest
        - <details>
              <summary>ui</summary>

            - about
            - ajustes
            - exit
            - home
            - reservas
            - user
            - FragmentoHolder.java
            - Intercambio.java
          </details>
        - Home.java
       </details>
    - loginRegister
    - MainActivity.java
  </details>
- <details>
    <summary>Resources</summary>

    - layout
    - menu
    - navigation
    - values
  </details>
- AndroidManifest.xml

--- 
## Java
### Aplicacion
#### Rest
> Contiene las clases necesarias para conectarse e interactuar con la API del backend.

> Clases en este paquete:
>- Api
>- ApiConfig
#### Ui
> Contiene los paquetes y clases necesarios para dotar de funcionalidad
> al menu lateral.
##### About
> Funcionalidad de "About Us".
##### Ajustes
> Permite cambiar la configuración de la aplicación.
##### Exit
> Permite que cuando se pulse el botón "Salir", te desloguees y vuelvas a la pantalla de login.
##### Home
> Contiene las clases necesarias para hacer posible el proceso de reservar una pista.

> Clases en este paquete:
>- SelecHora
>- SelecDia
>- ClickTipoPista
>- ReservaPreview
>- ClickPista
>- Home
>- AlquilarActivity
##### Reservas
> Contiene las clases relacionadas con las reservas: la clase modelo Reserva y la que
> permite ver el apartado "Mis reservas".

> Clases en este paquete:
>- VerMiReservaActivity
>- Reservas
##### User
> Contiene las clases relacionadas con las vistas de usuario.

> Clases en este paquete:
>- UserActivity
>- UserFragment
##### FragmentoHolder.java
> Esta es la interfaz que permite cambiar de fragmentos.
#####Intercambio.java
> Singleton que cumple la funcionalidad de un shared preferences, pero como clase java.
#### Home.java
>Clase que carga el menu lateral de la aplicación una vez el usuario se ha logueado.
### LoginRegister
> Paquete que gestiona el login y el register. Gracias a las clases de este paquete, los usuarios
> pueden crearse una cuenta y loguearse en nuestra aplicación.

> Clases en este paquete:
>- Login
>- Register
### MainActivity.java
> Clase main de la aplicación.
## Resources
### Layout
> Contiene los archivos xml con los layouts de los fragmentos y actividades de la aplicación.
### Menu
> Contiene los layouts del menú.
### Navigation
> Es lo que usa el menu para cambiar de fragmento al tocar una opcion en él.
### Values
> Contiene diferentes xml con los valores que toman ciertos elementos de los layouts.

> Contiene los siguientes archivos:
>- colors (asigna un valor hexadecimal a un nombre de color que podremos usar en otros layouts)
>- dimens (asigna unas dimensiones a los nombres que queramos)
>- strings (asigna una cadena de caracteres a un nombre que queramos. Usado para no hardcodear Strings)
>- themes (el equivalente a un css pero para android)
## AndroidManifest.xml
> Configuracion general de la aplicación.

---
## Hecho por:

| Programador             | GitHub                                       | Gmail                               |
|-------------------------|----------------------------------------------|-------------------------------------|
| Dylan Hurtado López     | [GitHub](https://github.com/DyLaNHurtado)    | [Gmail](dylanhurtado43@gmail.com)   |
| Eneko Rebollo Hernández | [GitHub](https://github.com/enekor)          | [Gmail](enekorebollo@gmail.com)     |
| Saúl Mellado Herrera    | [GitHub](https://github.com/saulmella12)     | [Gmail](saulmella12@gmail.com)      |
| Emilio López Novillo    | [GitHub](https://github.com/emilio2403)      | [Gmail](lopeznovillo2000@gmail.com) |
| Daniel Rodríguez Muñoz  | [GitHub](https://github.com/Idliketobealoli) | [Gmail](daniel.ro.mu02@gmail.com)   |