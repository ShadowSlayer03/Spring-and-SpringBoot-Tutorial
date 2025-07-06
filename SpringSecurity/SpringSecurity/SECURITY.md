# Spring Security

## Basic Working and Functionalities

- Since Spring Security is added as a dependency, it automatically creates a basic sign in page,logout page, CSRF protection, session management, password hashing etc.
- It automatically protects all endpoints (/**) by default by setting up a SecurityFilterChain.
- There is an order of filter execution in a SecurityFilterChain which we can customize if needed.
- You can access the sessionId(remains same across routes after a login) by using HttpServletRequest.

## Custom Username and Password(Only for Development)
Inside application.properties set:

- spring.security.user.name=arjun
- spring.security.user.password=12345678

## Cross Site Request Forgery(CSRF)

- This is a type of attack in which the cookies and sessionId
  stored by one website in our browser is being accessed by another website to emulate the logged in session to steal data.
- GET is usually safe and hence csrf token(X-CSRF-TOKEN header) is not required for requests.
- But X-CSRF-TOKEN must be sent on all methods like PUT, POST, DELETE because it is used to manipulate data and hence security should be stronger.

- Another way is to completely restrict another application from using the sessionId and cookie from this website.
- To do this we have to set in application.properties: server.servlet.session.cookie.same-site=strict
- Then we can disable the csrf token completely and authenticate any request by making everything STATELESS.
  But in this case we will have to use JWT or other methods to authenticate.

## Handling Real Users and their Login with the help of DB

- Create a custom method for user signin in the config.
- This user
