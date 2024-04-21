const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client.js');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/users/user-role?roleName=ROLE_USER'}).done(response => {
            this.setState({users: response.entity});
            console.log(response);
        });
    }

    render() {
        return (
            <UserList users={this.state.users}/>
        );
    }

}

class UserList extends React.Component {
    render() {
        const users = this.props.users.map(user =>
            <User key={user} user={user}/>
        );
        // console.log(users);
        return (
            <table>
                <tbody>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                    </tr>
                    {users}
                </tbody>
            </table>
        );
    };
}

class User extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.user.firstName}</td>
                <td>{this.props.user.lastName}</td>
                <td>{this.props.user.username}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('root')
)