command!(start(_ctx, msg, args) {
    let _ = msg.channel_id.say("Pong!");
    let first = args.single::<f64>()?;
    println!("{}",first);
});