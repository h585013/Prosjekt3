
import Login from './Pages/Login';
import Registration from './Pages/Registration';
import venterom from './Pages/Venterom/venterom';
import React, { Component } from 'react';
import {BrowserRouter, Link, Route, Switch} from 'react-router-dom';
import { Container, Grid } from '@material-ui/core';

//DETTE ER EN TEST! 

const App = () => {

  return (
    
    <main>
     <Switch>
        <Route path="/" component={Login} exact />
        <Route path="/registration" component ={Registration}/>
        <Route path="/venterom" component ={venterom}/>
      </Switch>

    </main>

  );
}


export default App;
