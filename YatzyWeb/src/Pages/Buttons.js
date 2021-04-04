
import {Button, makeStyles} from '@material-ui/core';

const useStyles = makeStyles({
    root: {
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(12,133,195, .3)',
        height: 48,
        padding: '0 30px',
    },

    primary: {
      background: '#0C85C3',
      border: 0,
      borderRadius: 3,
      color: 'white',
    },

    secondary: {
        background: '#white',
        borderColor:'#0C85C3',
        border: 10,
        borderRadius: 3,
        color: '#0C85C3',
    }

  });

  
  export function LoginButton(props) {
    const classes = useStyles();
    return <Button className={classes.root + " " + classes.primary } {...props}>{props.children}</Button>;
  }

  
  export function RegisterButton(props)  {
    
    const classes = useStyles();
    return <Button href='registration' className={classes.root + " " + classes.secondary}>{props.children}</Button>;
  }

  export function RegistrationButton(props) {

    const classes = useStyles();
    return <Button className={classes.root + " " + classes.primary } {...props}>{props.children}</Button>;
  }