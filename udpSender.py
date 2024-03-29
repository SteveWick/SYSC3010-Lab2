# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

host = sys.argv[1]
textport = sys.argv[2]
n = int(sys.argv[3])

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

port = int(textport)
server_address = (host, port)
for i in range(n):
    data = "Message " + str(i)
    # s.sendall(data.encode('utf-8'))
    s.sendto(data.encode('utf-8'), server_address)

    buf, address = s.recvfrom(port)
    print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))

s.shutdown(1)

