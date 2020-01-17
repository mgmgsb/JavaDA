package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleTest {

	@Test
	public void はじめてのテスト() {
		Account account = new Account("34", "minato", "mgmg@mgt.jp", "secret");
		assertEquals(account, new Account("34", "minato", "mgmg@mgt.jp", "secret"));
	}

}
