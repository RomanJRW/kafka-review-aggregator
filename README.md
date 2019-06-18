# kafka-review-aggregator

[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=RomanJRW/kafka-review-aggregator)](https://dependabot.com)

A fun little test project (WIP) for experimenting with kafka. Features a kafka producer that sends randomly generated reviews for fictional restaurants to a `restaurant.reviews` topic, a stream processor that aggregates messages from this topic and produces to other aggregation topics, plus a consumer that reads from each of these topics and outputs the results periodically.

## Prerequisites
Kafka, Zookeeper need to be installed and running. Each of the topics need creating separately too. When running, it will default to outputting to `System.out`
