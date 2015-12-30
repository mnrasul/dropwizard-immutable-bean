# dropwizard-immutable-bean
example of an error with jackson

I had a problem with Jackson and immutable beans.

Full discussion can be followed at https://mail.google.com/mail/u/0/?zx=khfzn67sm1i#label/dropwizard/150e3ec1e93ad69d

It is solved. See the code sample.


# Auth sample

Have a look at the classes under the auth package.

To check auth
`curl http://localhost:9000` expected response is `Can't touch this...`
`curl http://localhost:9000 --user abc:abc` expected response is `You got permission!`
