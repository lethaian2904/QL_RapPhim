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