public class KafkaReviewAggregator {

    public static void main(String[] args) {

        ReviewProducer reviewProducer = new ReviewProducer();
        reviewProducer.run();

    }

}
