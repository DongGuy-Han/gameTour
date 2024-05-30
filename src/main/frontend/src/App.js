import logo from './logo.svg';
import './App.css';

function App() {
    const handleLogin = () => {
        window.location.href = 'http://localhost:3000/login';
    };

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
                {/* 로그인 버튼 */}
                <button onClick={handleLogin}>Login</button>
            </header>
        </div>
    );
}

export default App;
