# Selenium Website Testing

Testing websites in containers using selenium framework and chrome engine

## Required software

- Java Development Kit
- Gradle
- (Docker)
- (JMeter)

## Usage Instructions

### Running using containers

Build container

```bash
docker build -t selenium-test .
```

Run container

```bash
docker run selenium-test
```

### Running locally

Install dependencies

```bash
gradle dependencies
```

Run tests

```bash
gradle dependencies
```

If you'd like to see the browser while testing, edit `test.conf` to set headless to false.

## JMeter Instructions

The `jmeter` folder contains the JMeter tests. Currenty there is a spike test using 3 threads of 15 requests. For real-world use this should be higher.
