package com.m.commons;

public class StaticInstanceBlocks {

	public StaticInstanceBlocks() {
		System.out.println("StaticInstanceBlocks:: 0-param Constructor");
	}

	public StaticInstanceBlocks(int a) {
		System.out.println("StaticInstanceBlocks:: param Constructor = " + a);
	}

	{
		System.out.println("Instance Block - 4");
	}
	{
		System.out.println("Instance Block - 2");
	}
	{
		System.out.println("Instance Block - 1");
	}
	{
		System.out.println("Instance Block - 3");
	}

	static {
		System.out.println("Static Block..!");
	}

	public static void main(String[] args) {

		System.out.println("Start.. !");

		StaticInstanceBlocks sib = new StaticInstanceBlocks();
		StaticInstanceBlocks sib1 = new StaticInstanceBlocks(234);
		StaticInstanceBlocks sib2 = new StaticInstanceBlocks();
		StaticInstanceBlocks sib3 = new StaticInstanceBlocks(554);

		System.out.println("End.. !");
	}
}
