package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileTest {
	private Profile profile;
	private Question question;
	private Criteria criteria;

	@BeforeEach
	void setUp() {
		profile = new Profile("Bull Hockey, Inc.");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();
	}

	@Test
	void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

		boolean matches = profile.matches(criteria);

		assertFalse(matches);
	}

	@Test
	void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

		boolean matches = profile.matches(criteria);

		assertTrue(matches);
	}
}