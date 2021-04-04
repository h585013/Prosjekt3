import React, { useState } from 'react';

import Grid from '@material-ui/core/grid';


const HomePage = ({onChange}) => {

    const [diceList, setDiceList] = useState([]);

    const addDiceRollToList = (diceRoll) => {
        let newDiceList = [diceRoll, ...diceList];
        setDiceList(newDiceList);
        console.log(newDiceList)
    } 

    return (
        <Grid
            container
            direction="row"
            justify="center"
            alignItems="center">
       
        </Grid>

    );

}

export default HomePage;

