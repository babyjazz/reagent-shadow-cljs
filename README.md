# React with reagent using shadow-cljs

### Requirement
- node-sass ``` npm i -g node-sass ```
- shadow-cljs ``` npm i -g shadow-cljs ```

### Installation
```
yarn install
```

### Run development
```
yarn start
```
Server will start at http://localhost:3000

### Connect REPL
```
yarn repl
```
use ``` (in-ns 'starter.core) ``` to switch namespace to first page

### Build production
```
yarn build
```
Production directory is in public folder. shadow-cljs will generate min main.js and replace to the same file

### Note
Credit. https://github.com/lauritzsh/reagent-shadow-cljs-starter

### License
MIT