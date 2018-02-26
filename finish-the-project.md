# Finish Up your Project

You will notice there are still many things left to do in our project.

This is not an exhaustive list, use your imagination and talk to your
instructors for guidance on feature scope.

- Reservation show page

    Create a page that shows the information about an individual reservation. This page
    should show all the information about that reservation, as well as the information
    about the user that created the reservation.

- Search

    Implement functionality that allows users to search through the reservations in your
    database.

- Show user's ads on their profile page

    When a user visits their profile page, they should see all of the ads they
    have created.

- Ensure usernames are unique

    We already modified the `username` and `email` columns
    of the `users` table are unique. Make sure a new account cannot be created
    with an existing username and catch the errors.

- Clean up the code

    You'll notice there is some duplicated code in our ads DAO and our users
    DAO. How could you create an abstraction for this?

- Dynamic navbar

    Would not it be nice if our navbar showed different links depending on if
    a user was logged in or out?

- Allow users to update and delete reservations

    You will need to make some changes to the frontend so that users can
    discover this functionality, as well as implement the backend logic
    necessary to update your database.

- Allow users to update their account information.

- Validate data

    Ensure that the data we get from our users is valid before saving it to the
    database. Consider creating some classes related to validation.

- Error messages

    Isn't it frustrating when a site won't let you submit a form but won't tell
    you why? Implement functionality to display error messages to users if they
    do something wrong, for example, if they try to register but their passwords
    don't match, or if they try to create a ad without a title.

    Consider storing error messages temporarily in the session and having a
    `messages.jsp` partial to handle this.

- Sticky Forms

    When a submission is rejected because one or more of our validation
    constraints fails, we should still see the old values in the form for
    creating a reservation, the user's input should not be erased.

- Allow a user to order online

    Create the `orders, items, orders_items` tables and implement all the backend logic necessary to
    allow the user to menu items online.
    
    Create a way to add menu items to the DB and edit them, having a seeder for menu items is a good idea to have something to start with.

- Make it pretty!

    While bootstrap is very helpful, our site could look much better than an out
    of the box bootstrap website. Recall your CSS prowess and style it up!
