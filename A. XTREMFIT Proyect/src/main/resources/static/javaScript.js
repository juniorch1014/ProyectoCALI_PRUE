
document.addEventListener("DOMContentLoaded", function() {
        // Definir una variable global para el estado de inicio de sesión
        
    // Función para cambiar el estado de inicio de sesión
    function cambiarEstadoInicioSesion() {
        // Verifica si la variable de sesión "sesionIniciada" está establecida en localStorage
        const sesionIniciada = localStorage.getItem("sesionIniciada");

        // Si la variable de sesión está establecida y su valor es "true", consideramos que el usuario ha iniciado sesión
        if (sesionIniciada === "true") {
            return true;
        } else {
            return false;
        }
    }
    
    
    const btPerfil          = document.getElementById("btPerfil");
    const btPlanes          = document.getElementById("btPlanes");
    const btNoticias        = document.getElementById("btNoticias");
    const btRecomendaciones = document.getElementById("btRecomendaciones");
    const btCalendario      = document.getElementById("btCalendario");

    // Función para actualizar el texto del botón en función del estado de inicio de sesión
    function actualizarEstadoBoton(usuarioHaIniciadoSesion) {
        const loginLink = document.getElementById("login-linkIC");

        if (usuarioHaIniciadoSesion) {
            loginLink.innerHTML = '<i class="bi bi-box-arrow-left btn btn-danger"> Cerrar Sesión</i>';
            btPerfil.style.display = "block";
            btPlanes.style.display = "block";
            btNoticias.style.display = "block";
            btRecomendaciones.style.display = "block";
            btCalendario.style.display = "block";
            
        } else {
            loginLink.innerHTML = '<i class="bi bi-box-arrow-right btn btn-info"> Iniciar Sesión</i>';
            btPerfil.style.display = "none";
            btPlanes.style.display = "block";
            btNoticias.style.display = "block";
            btRecomendaciones.style.display = "block";
            btCalendario.style.display = "none";
        }
    }


    const InicioLogin = document.getElementById("InicioLogin");
    if (InicioLogin) {
        InicioLogin.addEventListener("click", function() {
            localStorage.setItem("sesionIniciada", "true");
            actualizarEstadoBoton(cambiarEstadoInicioSesion());
        });
    }
    const cerrarButton = document.getElementById("login-linkIC");
    if (cerrarButton) {
        cerrarButton.addEventListener("click", function() {
        // Cuando el usuario cierra sesión, elimina la variable de sesión en localStorage
        localStorage.removeItem("sesionIniciada");
        actualizarEstadoBoton(cambiarEstadoInicioSesion());
        });
    }

    // Llama a la función para establecer el estado inicial
    actualizarEstadoBoton(cambiarEstadoInicioSesion());
    
});


