// <!-- Add this script block after your existing JavaScript code -->

// API TICKET TYPE
document.addEventListener("DOMContentLoaded", function () {
    // Function to fetch ticket types from the API
    function fetchTicketTypes() {
        fetch("/api/ticket_types")
            .then(response => response.json())
            .then(data => {
                // Process the data here, for example, update your ticket type dropdown
                updateTicketTypes(data);
            })
            .catch(error => console.error('Error fetching ticket types:', error));
    }

    // Function to update the ticket type dropdown
    function updateTicketTypes(ticketTypes) {
        const ticketTypeDropdown = document.getElementById("ticket-type");

        // Clear existing options
        ticketTypeDropdown.innerHTML = "";

        // Add new options from the fetched data
        ticketTypes.forEach(ticketType => {
            const option = document.createElement("option");
            option.value = ticketType.id; // or use another property from your TicketType class
            option.textContent = ticketType.name; // or use another property from your TicketType class
            ticketTypeDropdown.appendChild(option);
        });
    }

    // Call the fetchTicketTypes function when the page loads
    fetchTicketTypes();
});


// API SEAT
document.addEventListener("DOMContentLoaded", function () {
    // Other existing code...

    // Make an AJAX request to retrieve seat data from the server
    $.ajax({
        url: "http://localhost:8080/seats", // Change the URL to your actual server endpoint
        method: "GET",
        success: function (data) {
            // Process the data received from the server (data variable)
            console.log(data);
        },
        error: function (error) {
            console.error("Error fetching seat data:", error);
        }
    });

    // Other existing code...
});


// API SHOWTIME
document.addEventListener("DOMContentLoaded", function () {
    // Other existing code...

    // Replace {cinema_id} with the actual cinema id you want to fetch showtimes for
    const cinemaId = 1; // Replace with the desired cinema id

    // Make an AJAX request to retrieve showtimes data from the server
    $.ajax({
        url: `http://localhost:8080/api/cinemas/${cinemaId}/showtimes`, // Change the URL to your actual server endpoint
        method: "GET",
        success: function (data) {
            // Process the data received from the server (data variable)
            console.log(data);

            // Example: Display showtimes in the console
            data.forEach(showtime => {
                console.log(`Movie: ${showtime.movie.title}, Time: ${showtime.startTime}`);
            });
        },
        error: function (error) {
            console.error("Error fetching showtimes data:", error);
        }
    });

    // Other existing code...
});


// API SHOWTIME SEAT
document.addEventListener("DOMContentLoaded", function () {
    // Other existing code...

    // Replace {showtime_id} with the actual showtime id you want to fetch available seats for
    const showtimeId = 1; // Replace with the desired showtime id

    // Make an AJAX request to retrieve available seats data from the server
    $.ajax({
        url: `http://localhost:8080/api/showtimes/${showtimeId}/available_seats`, // Change the URL to your actual server endpoint
        method: "GET",
        success: function (data) {
            // Process the data received from the server (data variable)
            console.log(data);

            // Example: Display available seats in the console
            data.forEach(seat => {
                console.log(`Seat ID: ${seat.id}, Type: ${seat.type}`);
            });
        },
        error: function (error) {
            console.error("Error fetching available seats data:", error);
        }
    });

    // Other existing code...
});

