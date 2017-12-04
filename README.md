# A Dive Into Re-frame and Reactive Programming

* About Me
  - Working in the bay area the last 2 years
  - Mostly work with web based technology, but does
    whatever needs to get done: devops, backend, and frontend
  - Has a masters wtih a focus in machine learning

* Welcome
  - Shoutout to fun with clojure

* What is this talk about?
  - Introduction to Re-frame
  - Brief overview of reactive programming, plus a few other supplemental tools

* Example App
  - Bare minimum, essentially static
  - todo app

* Add a View
  - List of todos: ["act normal", "feed cat", "remember to breathe"]

* Add a model
  - The todos: [String]
  - Make them random

* Views to use the model

* Add events
  - Edit Todo
  - Delete Todo
  - Add Todo, Cancel Todo

* Add ajax and reg-fx
  - Edit
  - Delete
  - Add

* Go into more advanced subscriptions
  - Calculate total amount of todos
  - Average time to completion

* Compile time configuration with goog-define
  - Different ajax endpoint

* Adding styles with garden
  - example

* Javascript interop
  - define a javascript method
  - call a javascript method
  - create a javascript object

* What is re-frame?
  - A reactive programming framework for writing SPAs in clojurescript

* What is reactive programming?
  - Handling concurrency via a propogation of calculations

## Notes
- Show how to configure the environment
- Show how to add css via garden
- Re-frisk
