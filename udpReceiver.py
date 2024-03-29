# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

textport = sys.argv[1]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = ('localhost', port)
s.bind(server_address)
while True:

    print ("Waiting to receive on port %d : press Ctrl-C or Ctrl-Break to stop " % port)

    buf, address = s.recvfrom(port)
    
    print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))

    message = "ACK: " + buf.decode('utf-8')
    s.sendto(message.encode('utf-8'), address)


s.shutdown(1)
