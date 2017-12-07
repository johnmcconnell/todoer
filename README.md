# A Dive Into Re-frame and Reactive Programming

* Welcome
  - Thank you for coming here
  - I'm hoping you will get something out of it

* Introductions
  - Working in the bay area the last 2 years
  - Mostly work with web based technology, but does
    whatever needs to get done: devops, backend, and frontend

* Before we begin
  - Transition: I would like to discuss other resources.

* Other Resources
  - AOC: fun

* What is this talk about?
  - An introduction to re-frame
  - Getting started with a TO-DO app

* Getting Started
 - Transition: Let's take a look at it in the browser

* Create a UI

* Add Some Flare
 - Office Space

* [Blank]
 - 'resources/index.html'

* [Blank]
 - 'views.cljs'
 - Show core.cljs, render
 - First main-panel

* Flare Complete
 - Branch: add-some-style

* Add the todos
 - test.check

* Model
  - test.check allows you to generate values

* View
  - Simple iteration

* Subscriptions
  - Uses the value from the database

* Implementing Edit Task
  - Pretty good!
  - Let's make these todo items editable

* Model
  - We are adding an `edit?` flag

* Events
  - edit: assoc the edit flag
  - cancel-edit: dissoc the edit flag
  - save: dissoc the edit flag, and save input

* View
  - There are now two different todo views

* Now Implement Add and Finish
  - Nice additions!
  - Transition: How can we implement adding new todos and completing current todos?

* Events
  - finish: We have included javascript interop with pnotify.
  - new-todo: include a `new?` flag
  - change the cancel to remove if the task is `new?`
  - change save to remove `new?`

* View
  - There are now two different todo views

* Complete!
  - Looks nice!
  - Demo
    - Discuss re-frisk
  - https://github.com/frankiesardo/linked
  - About: ~250 lines of code

* Re-frame
  - Write your views in native clojurescript code and data structures
  - Helps you manage your state by avoiding callbacks and mutating variables

* Reactive Programming
  - Changing the paradigm from procedurally calculating values, to values are dervived calculations from other values
