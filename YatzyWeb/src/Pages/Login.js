
import React, {Component, useState} from 'react';
import './Login.css';

import 'fontsource-roboto';
import Grid from '@material-ui/core/grid';
import { Button, Container, TextField, Typography } from '@material-ui/core';
import {LoginButton, RegisterButton} from './Buttons';

const Login = () => {

    const [brukernavn, setBrukernavn] = useState("")
    const [passord, setPassord] = useState("")

    const handleLoginChange = (event) =>{

        // Ta brukernavn osv, poste til database.
        var payload = {
            "brukernavn" : brukernavn,
            "passord" : passord
        }

        fetch("http://localhost:8080/Prosjekt3/login", {
            method: "POST", 
            body: JSON.stringify(payload)
          }).then(res => {
            console.log("Request complete! response:", res);
          });

    }

    return(

        <Container maxWidth="md">

            <Grid
                container
                direction="column"
                justify="flex-end"
                alignItems="center"
                spacing={2}
            >
                <Grid item >
                <Typography variant="h1" component="h2" gutterBottom>
                 Yatzy
                 </Typography>
                    
                </Grid>
                <Grid item>
                <form noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Brukernavn" variant="filled" value={brukernavn} onChange={event=>setBrukernavn(event.target.value)}/>
                    </form>
                </Grid>
                <Grid item>
                     <form  noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Passord" variant="filled" type="password" value={passord} onChange={event=>setPassord(event.target.value)}/>
                    </form>
                </Grid>
                
                <Grid item>
                    <LoginButton onClick = {handleLoginChange}>
                        Logg inn
                    </LoginButton>
                </Grid>
                <Grid item>
                    <RegisterButton>
                        Ny Bruker
                    </RegisterButton>
                </Grid>
            </Grid>

        </Container>

    )
}

export default Login;
