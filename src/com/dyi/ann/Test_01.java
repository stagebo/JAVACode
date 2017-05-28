package com.dyi.ann;



import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

/**
 * 从这个例子可以看出，使用Encog实现一个神经网络主要分为三个部分： 1.建立神经网络的结构 2.训练网络 3.使用网络进行预测
 * 第一部分中，建立了一个三层的神经网络，BasicLayer的构造器中有三个重要的参数，第一个数激活函数的类型，第二个是确定是否存在偏移，第三个是该层有多少个神经元。
 * 可选的激活函数有以下几种，在例子中采用的是sigmoid函数，这个函数和Logistic回归采用的核函数是一样的。
 * 
 * 第二部分首先设置输入的训练数据集和目标数据集，然后在一个循环中进行神经网络的训练，直到误差小于0.01才结束。
 * 
 * 第三部分预测，这里使用训练数据进行预测，
 * 
 * @author Stagebo
 *
 */

public class Test_01 {

	/**
	 * the input necessary for XOR
	 */
	public static double XOR_INPUT[][] = { { 0.0, 0.0 }, { 1.0, 0.0 }, { 0.0, 1.0 }, { 1.0, 1.0 } };

	/**
	 * the ideal data necessary for XOR
	 */
	public static double XOR_IDEAL[][] = { { 0.0 }, { 1.0 }, { 1.0 }, { 0.0 } };

	/**
	 * @param no
	 *            arguments are used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a neural network, without using a factory
		BasicNetwork network = new BasicNetwork();

		// BasicLayer 参数： 激活函数、是否偏移、该层神经元数目
		network.addLayer(new BasicLayer(null, true, 2));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 3));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
		network.getStructure().finalizeStructure();

		// Reset the weight matrix and the bias values.
		// This will use a Nguyen-Widrow randomizer with a range between -1 and
		// 1.
		// If the network does not have an input, output or hidden layers, then
		// Nguyen-Widrow cannot be used and a simple range randomize between -1
		// and 1 will be used.
		network.reset();

		// create training data
		MLDataSet trainingSet = new BasicMLDataSet(XOR_INPUT, XOR_IDEAL);

		// train the neural network
		final ResilientPropagation train = new ResilientPropagation(network, trainingSet);

		int epoch = 1;

		do {
			train.iteration();
			System.out.println("Epoch #" + epoch + " Error: " + train.getError());
			epoch++;
		} while (train.getError() > 0.000000001);
		train.finishTraining();

		// test the neural network
		System.out.println("Neural Network Results: ");
		for (MLDataPair pair : trainingSet) {
			final MLData output = network.compute(pair.getInput());
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) + ", actual="
					+ output.getData(0) + ",ideal=" + pair.getIdeal().getData(0));
		}
		
		double[] a=new double[]{0,1};
		double output[]=new double[2];
		network.compute(a, output);
		
		System.out.println(output[0]+"++");
		Encog.getInstance().shutdown();
	}

}
