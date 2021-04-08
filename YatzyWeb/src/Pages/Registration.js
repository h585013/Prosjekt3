
import React, {Component, useState} from 'react';
import './Login.css';
import { useHistory } from "react-router-dom";


import 'fontsource-roboto';
import Grid from '@material-ui/core/grid';
import { Button, Container, TextField, Typography } from '@material-ui/core';
import {RegistrationButton} from './Buttons';

const Registration = () => {

    const [brukernavn, setBrukernavn] = useState("")
    const [epost, setEpost] = useState("")
    const [passord, setPassord] = useState("")
    const [passordRepeat, setPassordRepeat] = useState("")
    const history = useHistory()
    
    // for å sende variabler til en annen side: 
    //passord: hsashe, local store, lagre det samme men et objekt som har expirationDate
    //LocalStore
    //context, stateManagementLibrary => Redux, MobX. Bibliotek som er bygd oppå localStore. som abstrakterer mye ting. state træ
    //forskjellige ting. videreågende. heh så kanskje utenfor scopet av din første react-app 
    // enten bare gjøre det med local store, context, eller først bare google det. 'how to pass variables' 

    // GOOGLE: how to do simple login in react. 

    
    const handleRegistrationChange = (event) =>{

        // Ta brukernavn osv, poste til database.
        var payload = {
            "brukernavn" : brukernavn,
            "epost" : epost,
            "passord" : passord
         //   "passordRepeat" : passordRepeat
        }

        fetch("http://localhost:8080/Prosjekt3/registrer", {
            method: "POST", 
            body: JSON.stringify(payload)
          }).then(res => {            
            if(res.ok){
                window.location.assign("http://localhost:8080/Prosjekt3/Forside")
          }});
    }

//Få en token JWT token 

    return(

        <Container maxWidth="md">

            <Grid
                container
                direction="column"
                justify="flex-end"
                alignItems="center"
                spacing={2}
            >
                <Grid item>
                <Typography variant="h1" component="h2" gutterBottom>
                 Yatzy
                 </Typography>
                    
                </Grid>
                <Grid item>
                <form noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Brukernavn" variant="filled" value={brukernavn} 
                         onChange={event =>setBrukernavn(event.target.value)} />
                    </form>
                </Grid>
                <Grid item>
                     <form  noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Email" variant="filled" value={epost}
                          onChange={event => setEpost(event.target.value)} />
                    </form>
                </Grid>
                <Grid item>
                     <form  noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Passord" variant="filled" type="password" 
                         value={passord} onChange={event=>setPassord(event.target.value)} />
                    </form>
                </Grid>
                <Grid item>
                     <form  noValidate autoComplete="off">
                         <TextField id="filled-basic" label="Gjenta passord" variant="filled" type="password" 
                         value={passordRepeat} onChange={event=>setPassordRepeat(event.target.value)} />
                    </form>
                </Grid>
                <Grid item>
                    <RegistrationButton onClick={handleRegistrationChange}>
                        Registrer
                    </RegistrationButton>
                </Grid>
            </Grid>

        </Container>

    )
}

export default Registration;
