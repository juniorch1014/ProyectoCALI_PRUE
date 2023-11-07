
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

    // Función para actualizar el texto del botón en función del estado de inicio de sesión
    function actualizarEstadoBoton(usuarioHaIniciadoSesion) {
        const loginLink = document.getElementById("login-linkIC");

        if (usuarioHaIniciadoSesion) {
            loginLink.innerHTML = '<i class="bi bi-box-arrow-left"> Cerrar Sesión</i>';
        } else {
            loginLink.innerHTML = '<i class="bi bi-box-arrow-right"> Iniciar Sesión</i>';
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
    
  
//////////////////////////////////////////////////////
//////////////CALENDARIO/////////////////////////////
function buildCalendar(year, month) {
    const calendar = document.getElementById("calendar");
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const firstDayOfMonth = new Date(year, month, 1).getDay();

    const table = document.createElement("table");
    const tableBody = document.createElement("tbody");

    // Encabezados de días de la semana
    const daysOfWeek = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
    const headerRow = document.createElement("tr");
    daysOfWeek.forEach(day => {
        const th = document.createElement("th");
        th.textContent = day;
        headerRow.appendChild(th);
    });
    tableBody.appendChild(headerRow);

    let currentDay = 1;
    for (let week = 0; currentDay <= daysInMonth; week++) {
        const row = document.createElement("tr");
        for (let dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
            if (week === 0 && dayOfWeek < firstDayOfMonth) {
                // Celdas vacías al principio del primer día de la semana
                const emptyCell = document.createElement("td");
                row.appendChild(emptyCell);
            } else if (currentDay <= daysInMonth) {
                // Celdas con días del mes
                const cell = document.createElement("td");
                cell.textContent = currentDay;
                cell.className = "calendar-day";
                row.appendChild(cell);
                currentDay++;
            } else {
                // Celdas vacías al final de la última semana
                const emptyCell = document.createElement("td");
                row.appendChild(emptyCell);
            }
        }
        tableBody.appendChild(row);
    }

    table.appendChild(tableBody);
    calendar.appendChild(table);
    return table;
}

// Función para alternar clases de estilo al hacer clic en los días
function toggleDayColor(dayElement) {

    if (dayElement.classList.contains("green")) {
        dayElement.classList.remove("green");
        dayElement.classList.add("red");
    } else if (dayElement.classList.contains("red")) {
        dayElement.classList.remove("red");
    } else {
        dayElement.classList.add("green");
    }
}

// Función para generar el calendario dinámico
function generateCalendar(year, month) {
    const calendar = document.getElementById("calendar");
    const currentMonthName = monthNames[month];
    const monthTitle = document.getElementById("month-title");
    monthTitle.textContent = "Mes Actual: " + currentMonthName;

    // Construir el calendario y obtener la tabla creada
    const table = buildCalendar(year, month);

    // Agregar eventos de clic a los días del calendario
    const dayElements = table.querySelectorAll(".calendar-day");
    dayElements.forEach((dayElement) => {
        dayElement.addEventListener("click", () => {
            toggleDayColor(dayElement);
        });
    });

    // Limpiar el contenido del calendario y agregar el nuevo
    calendar.innerHTML = "";
    calendar.appendChild(table);
}

// Obtener la fecha actual
const currentDate = new Date();
const currentYear = currentDate.getFullYear();
const currentMonth = currentDate.getMonth();

// Nombres de los meses
const monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

// Generar el calendario para el mes actual
generateCalendar(currentYear, currentMonth);
 
        
        
});

