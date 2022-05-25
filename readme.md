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

## Disclaimer

I in no way promote or take accountability for your use of this software. Only use for sites where you have explicit permission to use bots and test performance.

`notion.so` is not associated or gave no permission to use this on their system, so modify each orrucence of their URL to your own target before use.
