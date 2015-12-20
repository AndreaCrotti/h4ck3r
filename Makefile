deploy:
	git push -v heroku master

ring:
	lein ring server
