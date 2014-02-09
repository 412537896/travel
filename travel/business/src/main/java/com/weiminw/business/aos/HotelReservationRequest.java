package com.weiminw.business.aos;

import java.util.concurrent.Callable;










import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.model.PushUnicastMessageRequest;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.weiminw.business.workers.NotifyMessageSendWorker;
import com.weiminw.travel.interfaces.IReservationRequest;
import com.weiminw.travel.interfaces.IUser;

public class HotelReservationRequest implements IReservationRequest{
	private final static Logger logger = LogManager.getLogger(HotelReservationRequest.class);
	private String message = "预定一间大床房,价格200~300之间";
	private IUser sender;
	private IUser receiver;
	private NotifyMessageSendWorker work = NotifyMessageSendWorker.create();
	private HotelReservationRequest(IUser sender, IUser receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}

	public static IReservationRequest create(IUser sender, IUser receiver) {
		return new HotelReservationRequest(sender,receiver);
	}

	@Override
	public void send() {
		work.send(this);
	}
	public static void main(String[] args) {
		IReservationRequest request = HotelReservationRequest.create(IUser.NONE, IUser.NONE);
		request.send();
	}

	@Override
	public IUser getReceiver() {
		// TODO Auto-generated method stub
		return this.receiver;
	}

	@Override
	public IUser getSender() {
		// TODO Auto-generated method stub
		return this.sender;
	}

}
