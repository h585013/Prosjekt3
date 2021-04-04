
import Login from './Pages/Login';
import Registration from './Pages/Registration';
import React, { Component } from 'react';
import {BrowserRouter, Link, Route, Switch} from 'react-router-dom';
import { Container, Grid } from '@material-ui/core';



const App = () => {

  return (
    
    <main>
     <Switch>
        <Route path="/" component={Login} exact />
        <Route path="/registration" component ={Registration}/>
      </Switch>

    </main>

  );
}


  

const NavBar =() => {
  return(

    <Grid container justify="flex-start" spacing={5}>
      <Grid item>
        <Link to ="/">Home</Link>
      </Grid>

      <Grid item>
        <Link to ="/about">About us</Link>
      </Grid>
      

    </Grid>
  )
}

export default App;
