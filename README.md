# h4ck3r

Encode strings in shorter but still readable sentences, send funny
coded messages or tweets.

Only one endpoint is probably necessary:

- POST which contains the message and the strategy

## Possible strategies to use

- no vowels
- cut word (variable or fixed size)
- synonym finder for shorter words (integrate with an existing dictionary)
- the return string should also contain the MAP with the generated things

## TODOS

- integrate with the twitter API to shorten tweets even more
- generate suggestions on tweets to shorten words by leaving the meaning

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2015 FIXME
