import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    scenarios: {
        scenario1: {
            executor: 'constant-vus',
            vus: 10,
            duration: '30s',
            exec: 'scenario1',
        },
        scenario2: {
            executor: 'constant-vus',
            vus: 10,
            duration: '30s',
            exec: 'scenario2',
        },
    },
};

export function scenario1() {
    const res = http.get('https://test.k6.io');
    console.log(`Scenario 1 - Response time: ${res.timings.duration} ms`);
    sleep(1);
}

export function scenario2() {
    const payload = JSON.stringify({
        name: 'testuser',
        email: 'testuser@example.com',
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post('https://test-api.k6.io/endpoint', payload, params);

    check(res, {
        'status is 201': (r) => r.status === 201,
    });

    console.log(`Scenario 2 - Response time: ${res.timings.duration} ms`);
    sleep(2);
}
